Ext.define('App.view.HudagGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.HudagGrid',
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
                    action:'gridDelete'
                },
                '->',
                {
                    xtype: 'textfield',
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
                    action: 'gridSave'
                    ,
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
    store:'HudagStore',
    columns: [

        {
            text: '#',
            hidden: true,
            width: 100,
            editor: {
                xtype: 'numberfield',
                allowDecimals: false
            },

            dataIndex: 'hudagId'
        }
        ,
        {
            text: 'Аймагын нэр',
            hidden: true,
            width: 100,
            editor: {
                xtype: 'combo',
                queryMode: 'local',
                displayField: 'value',
                editable: false,
                valueField: 'id',
                store: Ext.create('App.store.AimagStore')
            },
            dataIndex: 'aimagId',
            summaryType: 'count',
            hideable: false,
            summaryRenderer: function (value, summaryData, dataIndex) {
                return ((value === 0 || value > 1) ? '(Нийт: ' + value + ')' : '(Нийт: 1)');
            }
        }
        ,
        {
            text: 'Дугаар',
            width: 100,
            editor: {
                xtype: 'numberfield',
                allowDecimals: false
            },

            dataIndex: 'dugaar'
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
                            id: 'TD',
                            value: 'Цэвэр, Дулаан'
                        },
                        {
                            id: 'BO',
                            value: 'Бохрын'
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
                    case  'TD' :
                        return  'Цэвэр, Дулаан';
                    case  'BO' :
                        return  'Бохрын';
                }
            },

            dataIndex: 'torol'
        }
        ,
        {
            text: 'Материал',
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
                            id: 12,
                            value: 'мод'
                        },
                        {
                            id: 13,
                            value: 'чулуу'
                        },
                        {
                            id: 14,
                            value: 'бетон, блок'
                        },
                        {
                            id: 15,
                            value: 'тоосго'
                        },
                        {
                            id: 16,
                            value: 'төмөр'
                        },
                        {
                            id: 17,
                            value: 'блок'
                        },
                        {
                            id: 18,
                            value: 'бетон'
                        },
                        {
                            id: 19,
                            value: 'хуванцар'
                        },
                        {
                            id: 24,
                            value: 'тоосго '
                        }
                    ]
                })
            },
            renderer: function (value) {
                switch (value) {
                    case  12 :
                        return  'мод';
                    case  13 :
                        return  'чулуу';
                    case  14 :
                        return  'бетон, блок';
                    case  15 :
                        return  'тоосго';
                    case  16 :
                        return  'төмөр';
                    case  17 :
                        return  'блок';
                    case  18 :
                        return  'бетон';
                    case  19 :
                        return  'хуванцар';
                    case  24 :
                        return  'тоосго ';
                }
            },

            dataIndex: 'materialId'
        }
        ,
        {
            text: 'Өргөн',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'orgon'
        }
        ,
        {
            text: 'Урт',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'urt'
        }
        ,
        {
            text: 'Голч',
            width: 100,
            editor: {
                xtype: 'textfield'
            },

            dataIndex: 'golch'
        }
        ,
        {
            text: 'Таг тэмдэгт',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'tagTmdgt'
        }
        ,
        {
            text: 'Хоол.ёроол',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'hooloiErool'
        }
        ,
        {
            text: 'Худаг.ёроол',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'hudagErool'
        }
        ,
        {
            text: 'Газрын.Тмдгт',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'gazTemdegt'
        }
        ,
        {
            text: 'Хаалт',
            width: 100,
            editor: {
                xtype: 'numberfield'
            },

            dataIndex: 'haalt'
        }
        ,
        {
            text: 'Тайлбар',
            width: 100,
            editor: {
                xtype: 'textfield'
            },

            dataIndex: 'tailbar'
        }
        ,
        {
            text: 'Болсон',
            width: 100,
            xtype: 'checkcolumn',
            editor: {
                xtype: 'checkbox',
                cls: 'x-grid-checkheader-editor'
            },

            dataIndex: 'ok'
        }
    ]
})