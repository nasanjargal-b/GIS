Ext.define('App.view.HudagWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.hudagWindow',
    width: 823,
    height: 600,
    autoShow: true,
    border: false,
    layout: 'fit',
    modal: true,
    items: {
        xtype: 'form',
        layout: 'border',
        border: false,
        frame: true,
        items: [
            {
                region: 'center',
                xtype: 'panel',
                border: false,
                bodyStyle: 'background-color:#dfe8f6',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                defaults: {
                    margin: 5
                },
                items: [
                    {
                        xtype: 'panel',
                        border: false,
                        layout: 'form',
                        bodyStyle: 'background-color:#dfe8f6',
                        flex: 0.5,
                        items: [
                            {
                                xtype: 'hiddenfield',
                                name: 'aimagId'
                            },
                            {
                                xtype: 'hiddenfield',
                                name: 'hudagId'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'dugaar',
                                allowBlank: false,
                                fieldLabel: 'Дугаар'
                            },
                            {
                                xtype: 'combo',
                                store: Ext.create('Ext.data.Store', {
                                    data: [
                                        {id: 'TS', value: 'Цэвэр'},
                                        {id: 'DU', value: 'Дулаан'},
                                        {id: 'BO', value: 'Бохирын'},
                                        {id: 'TD', value: 'Цэвэр, Дулаан'}
                                    ],
                                    fields: ['id', 'value']
                                }),
                                displayField: 'value',
                                valueField: 'id',
                                editable: false,
                                name: 'torol',
                                fieldLabel: 'Төрөл'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'orgon',
                                fieldLabel: 'Өргөн'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'urt',
                                fieldLabel: 'Урт'
                            },
                            {
                                xtype: 'textfield',
                                name: 'golch',
                                fieldLabel: 'Голч'
                            }
                            ,
                            {
                                xtype: 'combo',
                                fieldLabel:'Таг',
                                typeAhead: false,
                                store:Ext.create('App.store.TagStore'),
                                valueField:'tagId',
                                displayField:'name',
                                action:'tagToo',
                                queryMode:'local',
                                name:'tagId'
                            },
                            {
                                xtype: 'combo',
                                name: 'materialId',
                                editable: false,
                                store: 'HudagMaterialStore',
                                valueField: 'materialId',
                                displayField: 'name',
                                fieldLabel: 'Мартериал',
                                queryMode: 'local',
                                typeAhead: false,
                                tpl: Ext.create('Ext.XTemplate',
                                    '<tpl for=".">',
                                    '<div class="x-boundlist-item">{materialId} - {name}</div>',
                                    '</tpl>'
                                ),
                                // template for the content inside text field
                                displayTpl: Ext.create('Ext.XTemplate',
                                    '<tpl for=".">',
                                    '{name}',
                                    '</tpl>'
                                )
                            }
                        ]
                    },
                    {
                        xtype: 'panel',
                        layout: 'form',
                        border: false,
                        bodyStyle: 'background-color:#dfe8f6',
                        flex: 0.5,
                        items: [
                            {
                                xtype: 'numberfield',
                                name: 'tagTmdgt',
                                fieldLabel: 'Таг тэмдэгт'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'gazTemdegt',
                                fieldLabel: 'Газрын тэмдэгт'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'hooloiErool',
                                fieldLabel: 'Хоол.ёроол'
                            },
                            {
                                xtype: 'numberfield',
                                name: 'hudagErool',
                                fieldLabel: 'Худаг.ёроол'
                            },
                            {
                                xtype: 'checkbox',
                                name: 'ok',
                                fieldLabel: 'Болсон'
                            },
                            {
                                xtype:'textfield',
                                fieldLabel:'Тагны тоо',
                                enableKeyEvents:true,
                                name:'tagToo',
                                isFormField:false,
                                action:'tagToo'
                            },
                            {
                                xtype: 'textfield',
                                name: 'tailbar',
                                fieldLabel: 'Тайлбар'
                            }
                        ]
                    }
                ]
            }
            ,
            {
                region: 'south',
                flex: 1.6,
                height: 400,
                xtype: 'hudagShugamGrid',
                sortable: false
            }
        ]
    },
    buttons: [
        {
            text: 'Хадгалах/Нэмэх',
            action: 'saveNew'
        },
        {
            text: 'Хадгалах',
            action: 'save'
        },
        {
            text: 'Хаах',
            listeners: {
                click: function (btn) {
                    btn.up('window').close();
                }
            }
        }
    ]
})