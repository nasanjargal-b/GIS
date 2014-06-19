//var store = Ext.create('App.store.HudagShugamStore');
Ext.define('App.view.HudagShugamGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.hudagShugamGrid',

    store: Ext.create('App.store.HudagShugamStore'),
    flex: 1,
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 1
        })
    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Нэмэх',
                    action: 'add'
                },
                {
                    text: 'Засах',
                    action: 'edit'
                },
                {
                    text: 'Устгах',
                    listeners: {
                        click: function (btn) {
                            var grid = btn.up('grid');
                            var model = grid.getSelectionModel().getSelection()[0];
                            if (model) {
                                Ext.MessageBox.confirm('Асуулт', 'Та уг мөрийг устгахдаа итгэлтэй байна уу?', function (val) {
                                    if (val == 'yes') {
                                        grid.getStore().remove(model);
                                        grid.getStore().sync({
                                            success: function () {
                                                grid.getStore().remove(model);
                                            },
                                            failure: function (response, options) {
                                                Ext.MessageBox.alert('Алдаа', 'Устгах боломжгүй. Энэ мэдээлэл өөр мэдээлэлтэй холбогдсон байна!!!')
                                                grid.getStore().reload()
                                            }
                                        });
                                    }
                                });
                            } else {
                                Ext.MessageBox.alert('Алдаа', 'Та устгах мөрөө сонгоно уу!!!')
                            }
                        }
                    }
                },
                '->',
                {
                    xtype: 'textfield',
                    isFormField: false,
                    enableKeyEvents: true,
                    action: 'search'
                },
                {
                    xtype: 'button',
                    text: 'Хайх',
                    action: 'search'
                },

                {
                    text: 'Өөрчлөлтийг хадгал',
                    action: 'gridSave',
                    listeners: {
                        click: function (btn) {
                            Ext.MessageBox.confirm('Асуулт', 'Та өөрчлөлтийг хадгалахдаа итгэлтэй байна уу?', function (val) {
                                if (val == 'yes') {
                                    btn.up('grid').getStore().sync();
                                }
                            });
                        }
                    }
                }
            ]
        }
    ],
    features: [
        {
            ftype: 'summary',
            dock: 'bottom'
        }
    ],
    columns: [

        {
            text: '#',
            hidden: true,
            width: 100,
            editor: {
                xtype: 'numberfield',
                allowDecimals: false
            },

            dataIndex: 'hudagShugamId'
        }
        ,
        {
            text: 'Зүг',
            width: 100,
            editor: {
                xtype: 'combo',
                queryMode: 'local',
                displayField: 'value',
                editable: false,
                valueField: 'id',
                store: Ext.create('Ext.data.Store', {
                    fields: ['id', 'value'],
                    data: [
                        {
                            id: 'B',
                            value: 'Баруун'
                        },
                        {
                            id: 'Z',
                            value: 'Зүүн'
                        },
                        {
                            id: 'H',
                            value: 'Хойд'
                        },
                        {
                            id: 'U',
                            value: 'Урд'
                        },
                        {
                            id: 'BH',
                            value: 'Баруун хойд'
                        },
                        {
                            id: 'ZH',
                            value: 'Зүүн хойд'
                        },
                        {
                            id: 'BU',
                            value: 'Баруун урд'
                        },
                        {
                            id: 'ZU',
                            value: 'Зүүн урд'
                        }
                    ]
                })
            },
            renderer: function (value) {
                switch (value) {
                    case  'B' :
                        return  'Баруун';
                    case  'Z' :
                        return  'Зүүн';
                    case  'H' :
                        return  'Хойд';
                    case  'U' :
                        return  'Урд';
                    case  'BH' :
                        return  'Баруун хойд';
                    case  'ZH' :
                        return  'Зүүн хойд';
                    case  'BU' :
                        return  'Баруун урд';
                    case  'ZU' :
                        return  'Зүүн урд';
                }
            },

            dataIndex: 'zug',
            summaryType: 'count',
            hideable: false,
            summaryRenderer: function (value, summaryData, dataIndex) {
                return ((value === 0 || value > 1) ? '(Нийт: ' + value + ')' : '(Нийт: 1)');
            }
        }
        ,
        {
            text: 'Төрөл',
            width: 100,
            editor: {
                xtype: 'combo',
                queryMode: 'local',
                displayField: 'value',
                editable: false,
                valueField: 'id',
                store: Ext.create('Ext.data.Store', {
                    fields: ['id', 'value'],
                    data: [
                        {
                            id: 'DU',
                            value: 'Дулаан'
                        },
                        {
                            id: 'TS',
                            value: 'Цэвэр'
                        },
                        {
                            id: 'BO',
                            value: 'Бохир'
                        }
                    ]
                })
            },
            renderer: function (value) {
                switch (value) {
                    case  'DU' :
                        return  'Дулаан';
                    case  'TS' :
                        return  'Цэвэр';
                    case  'BO' :
                        return  'Бохир';
                }
            },

            dataIndex: 'torol'
        }
        ,
        {
            text: 'Диаметер',
            enableKeyEvents: true,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'diameter'
        }
        ,
        {
            text: 'тоо',
            width: 100,
            editor: {
                xtype: 'numberfield',
                allowDecimals: false
            },

            dataIndex: 'too'
        }
        ,
        {
            text: 'Материал',
            xtype: 'gridcolumn',
            width: 100,
            editor: {
                xtype: 'combo',
                queryMode: 'local',
                transform: 'name',
                displayField: 'name',
                editable: false,
                valueField: 'materialId',
                store: Ext.create('App.store.HooloiMaterialStore'),
                listeners: {
                    select: function (field, e) {
                        field.up('grid').getSelectionModel().getSelection()[0].set('hSmaterialName', field.rawValue);
                    }
                }
            },
            dataIndex:'hSmaterialId',
            renderer: function (value, field, data) {
                return data.get('hSmaterialName');
            }
        }
        ,
        {
            text: 'Хаалт',
            width: 100,
            editor: {
                xtype: 'combo',
                queryMode: 'local',
                displayField: 'name',
                editable: false,
                action: 'haaltRow',
                valueField: 'materialId',
                store: Ext.create('App.store.HaaltMaterialStore'),
                listeners: {
                    select: function (field, e) {
                        field.up('grid').getSelectionModel().getSelection()[0].set('haaltName', field.rawValue);
                    }
                }
            },
            dataIndex: 'haaltId',
            renderer: function (value, field, data) {
                return data.get('haaltName');
            }
        }
        ,
        {
            text: 'Хаалт Диаметер',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'haaltDiameter'
        }
        ,
        {
            text: 'Хаалт тоо',
            width: 100,
            editor: {
                xtype: 'numberfield',
                allowDecimals: false
            },

            dataIndex: 'haaltToo'
        }
    ]
})