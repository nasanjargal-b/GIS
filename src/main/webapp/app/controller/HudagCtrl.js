Ext.define('App.controller.HudagCtrl', {
    extend: 'Ext.app.Controller',
    stores: [
        'HudagStore',
        'HudagShugamStore',
        'HudagMaterialStore'
    ],
    views: [
        'HudagGrid'
        ,
        'HudagShugamGrid'
        ,
        'HudagWindow'
    ],
    models:[
        'HudagShugamModel'
    ],
    init: function () {
        var val = window.location.href;
        val = val.split(/=/)[1]
        var title, windReload = false;
        this.control({

            'HudagGrid button[action="add"]': {
                click: function (btn) {
                    var win = this.getHudagWindowView().create();
                    win.down('grid').getStore().load()
                    win.down('combo[name="torol"]').setValue(val);
                    var maxDugaar = 0;
                    var bool = false
                    if (val == 'BO') {
                        bool = true
                    }
                    Ext.Ajax.request({
                        url: '/hudag/hudags.json',
                        method: 'get',
                        params: {
                            torol: val
                        },
                        success: function (response, opts) {
                            var obj = Ext.decode(response.responseText);
                            for (var obj1 in obj.data) {
                                maxDugaar = (maxDugaar < obj.data[obj1].dugaar) ? obj.data[obj1].dugaar : maxDugaar;
                            }
                            win.down('numberfield[name="dugaar"]').setValue(maxDugaar + 1);
                        },
                        failure: function (response, opts) {
                            Ext.MessageBox.alert('Алдаа', response.responseText);
                        }
                    });
                }
            },
            'HudagGrid': {
                afterrender: function (grid) {
                    var bool = false
                    var torol = 'TD'
                    if (val == 'BO') {
                        torol = 'BO'
                        bool = true
                    }
                    grid.getStore().load({
                        params: {
                            torol: torol
                        }
                    })
                    if (val == 'DU') {
                        title = 'Дулааны худаг'
                    }
                    if (val == 'TS') {
                        title = 'Цэвэрийн худаг'
                    }
                    if (val == 'TD') {
                        title = 'Цэвэр,дулааны худаг'
                    }
                    if (val == 'BO') {
                        title = 'Бохир худаг'
                    }
                    grid.setTitle(title)

//                    grid.headerCt.insert(0, Ext.create('Ext.grid.RowNumberer', {
//                        width: 40
//                    }));
                }
            },
            'HudagGrid button[action="gridDelete"]':{
                click: function(btn){
                    this.gridDelete(btn,val)
                }
            },
            'HudagGrid component[action="search"]': {
                click: function (btn) {
                    var grid = btn.up('panel');
                    var value = btn.up('panel').down('textfield[action="search"]').getValue();
                    grid.getStore().load({
                        params: {
                            dugaar: value,
                            torol: val,
                            bohir: true
                        }
                    })
                },
                keypress: function (field, e) {
                    console.log(field);
                    if (e.getKey() == 13) {
                        var grid = field.up('panel');
                        var value = field.up('panel').down('textfield[action="search"]').getValue();
                        grid.getStore().load({
                            params: {
                                dugaar: value,
                                torol: val,
                                bohir: true
                            }
                        })
                    }
                }
            },
            'HudagGrid button[action="edit"]': {
                click: function () {
                    var grid = Ext.ComponentQuery.query("HudagGrid")[0];
                    var model = grid.getSelectionModel().getSelection()[0];
                    if (model) {
                        var win = this.getHudagWindowView().create();
                        win.down('combo[name="materialId"]').getStore().load();
                        win.down('form').load({
                            url: '/hudag/hudag.json',
                            method: 'get',
                            params: {
                                id: model.get('hudagId')
                            }
                        });
                        win.down('hudagShugamGrid').getStore().load({
                            params:{
                                hudagId:model.get('hudagId')
                            }
                        })
                    } else {
                        Ext.MessageBox.alert('Алдаа', 'Та засах мөрөө сонгоно уу!!!');
                    }
                }
            },
            'hudagWindow button[action="save"]': {
                click: function (btn) {
                    windReload = true;
                    this.save(btn, windReload, val)
                }
            },
            'hudagWindow button[action="saveNew"]': {
                click: function (btn) {
                    windReload = false;
                    this.save(btn, windReload, val)
                }
            },
            'hudagWindow button[action="gridSave"]': {
                afterrender: function (btn) {
                    btn.hide()
                }
            },
            'hudagWindow component[action="search"]': {
                afterrender: function (btn) {
                    btn.hide()
                }
            },
            'hudagWindow component[action="tagToo"]':{
                keyup:function(field){
                    this.setTailbar(field);

                },
                select:function(field){
                    this.setTailbar(field);
                }
            },
            'hudagShugamGrid':{
                afterrender:function(grid){
                    grid.getStore().load();
                    grid.getStore().removeAll()
                }
            },
            'hudagWindow button[action="add"]': {
                click: function (btn) {
                    var store = btn.up('grid').getStore();

                    var model = store.first();
                    if (model) {
                        model = model.copy();

                        model.set({
                            hudagShugamId: null,
                            zug: null,
                            torol: val,
                            diameter: 0,
                            too: 0,
                            hSmaterialId: null,
                            hSmaterialName: null,
                            haaltDiameter: 0,
                            haaltToo: 0,
                            haaltId: null,
                            haaltName: null
                        });
                    } else {
                        model = {
                            hudagShugamId: null,
                            zug: null,
                            torol: val,
                            diameter: 0,
                            too: 0,
                            hSmaterialId: null,
                            hSmaterialName: null,
                            haaltDiameter: 0,
                            haaltToo: 0,
                            haaltId: null,
                            haaltName: null
                        };
                    }
                    store.add(model);
                }
            },
            'hudagWindow hudagShugamGrid gridview': {
                itemupdate: function (record, index, node, eOpts) {
                    if (record.get('haaltId') != 0 && record.get('haaltToo') == 0 && record.get('haaltDiameter') == 0) {
                        record.set('haaltToo', record.get('too'));
                        record.set('haaltDiameter', record.get('diameter'));
                    }
                }
            },
            'hudagWindow button[action="delete"]': {
                click: function (btn) {
                    var store = btn.up('grid').getStore();
                    var selection = btn.up('grid').getSelectionModel().getSelection()[0];
                    store.remove(selection)
                }
            },
            'hudagWindow button[action="edit"]': {
                afterrender: function (btn) {
                    btn.hide()
                }
            }
        })
    },
    save: function (btn, windReload, val) {
        var me = this;
        var hudagStore= Ext.ComponentQuery.query('HudagGrid')[0].getStore()
        var win = btn.up('window');
        var store = btn.up('window').down('grid').getStore();
        var jsonData = Ext.encode(Ext.pluck(store.data.items, 'data'));
        var checked = true;
        for (var i = 0; i < store.data.items.length; i++) {
            if (store.data.items[i].get('zug') == "" || store.data.items[i].get('torol') == "" || store.data.items[i].get('materialId') == 0) {
                checked = false;
            }
        }
        var form = win.down('form');
        var datas = form.getForm().getValues();
        if (form.getForm().isValid()) {
            var hudagShugams = Ext.decode(jsonData, true);
            if (datas['materialId'][0]) {
                datas['materialId'] = datas['materialId'][0];
            }
            if (datas['torol'][0] && datas['torol']instanceof Array) {
                datas['torol'] = datas['torol'][0];
            }
            if (datas.ok == 'on') {
                datas.ok = true;
            } else {
                datas.ok = false;
            }
            Ext.Ajax.request({
                url: '/hudag/hudag.json',
                method: 'post',
                jsonData: {
                    aimagId: datas.aimagId,
                    dugaar: datas.dugaar,
                    gazTemdegt: datas.gazTemdegt,
                    golch: datas.golch,
                    haalt: datas.haalt,
                    hooloiErool: datas.hooloiErool,
                    hudagErool: datas.hudagErool,
                    hudagId: datas.hudagId,
                    materialId: datas.materialId,
                    ok: datas.ok,
                    orgon: datas.orgon,
                    tagTmdgt: datas.tagTmdgt,
                    tailbar: datas.tailbar,
                    torol: datas.torol,
                    urt: datas.urt,
                    tagId: datas.tagId,
                    hudagShugams:hudagShugams
                },
                success: function () {
                    hudagStore.load({
                        method: 'get',
                        params: {
                            torol: val
                        },
                        callback:function(){
                            if (windReload == true) {
                                var grid= Ext.ComponentQuery.query('HudagGrid')[0]
                                btn.up('window').close();
                            } else {
                                win.close();
                                var win1 = me.getHudagWindowView().create();
                                win1.down('combo[name="torol"]').setValue(val);
                                var maxDugaar = 0;
                                var bool = false
                                if (val == 'BO') {
                                    bool = true
                                }
                                Ext.Ajax.request({
                                    url: '/hudag/hudags.json',
                                    method: 'get',
                                    params: {
                                        torol: val
                                    },
                                    success: function (response, opts) {

                                        var obj = Ext.decode(response.responseText);
                                        for (var obj1 in obj.data) {
                                            maxDugaar = (maxDugaar < obj.data[obj1].dugaar) ? obj.data[obj1].dugaar : maxDugaar;
                                        }
                                        console.log(maxDugaar);
                                        win1.down('numberfield[name="dugaar"]').setValue(maxDugaar + 1);

                                    },
                                    failure: function (response, opts) {
                                        Ext.MessageBox.alert('Алдаа', response.responseText);
                                    }
                                });


                            }
                        }
                    });

                },
                failure: function (response) {
                    Ext.MessageBox.alert('Алдаа', 'Та алдаатай мэдээлэл эсвэл буруу өгөгдөл оруулсан байна!');
                }
            });
        }
    },
    setTailbar:function(field){
        var tailbart = field.up('form').down('textfield[name="tailbar"]');
        var combo = field.up('form').down('combo[name="tagId"]').getDisplayValue();
        var text = field.up('form').down('textfield[name="tagToo"]').getValue();
        tailbart.setValue("");
        tailbart.setValue(text+'ш '+combo);
    },
    gridDelete:function (btn,torol) {
        var grid = btn.up('grid');
        var model = grid.getSelectionModel().getSelection()[0];
        if (model) {
            Ext.MessageBox.confirm('Асуулт', 'Та уг мөрийг устгахдаа итгэлтэй байна уу?', function (val) {
                if (val == 'yes') {
                    Ext.Ajax.request({
                        url:'/hudag/delete.json',
                        method:'post',
                        jsonData:{
                            hudagId:model.get('hudagId')
                        },
                        success:function(){
                            grid.getStore().load({
                                method: 'get',
                                params: {
                                    torol: torol
                                }
                            });
                        }
                    })
                }
            });
        } else {
            Ext.MessageBox.alert('Алдаа', 'Та устгах мөрөө сонгоно уу!!!')
        }
    }
});