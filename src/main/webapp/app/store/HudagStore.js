Ext.define('App.store.HudagStore', {
    extend: 'Ext.data.Store',
    fields: [
        {name: 'hudagId', type: 'int'}
        ,{name: 'aimagId', type: 'int'}
        ,{name: 'dugaar', type: 'int'}
        ,{name: 'torol', type: 'auto'}
        ,{name: 'materialId', type: 'int'}
        ,{name: 'orgon', type: 'float'}
        ,{name: 'urt', type: 'float'}
        ,{name: 'golch', type: 'string'}
        ,{name: 'tagTmdgt', type: 'float'}
        ,{name: 'hooloiErool', type: 'float'}
        ,{name: 'hudagErool', type: 'float'}
        ,{name: 'gazTemdegt', type: 'float'}
        ,{name: 'haalt', type: 'float'}
        ,{name: 'tailbar', type: 'string'}
        ,{name: 'ok', type: 'boolean'}
    ],
    autoLoad: false,
    hasMany:{model:'App.model.HudagShugamModel',name:'hudagShugams'},
    proxy: {
        url: '/hudag/hudags.json',
        type: 'ajax',
        reader: {
            type: 'json',
            root: 'data'
        },
        actionMethods: {
            read: 'get',
            create: 'post',
            update: 'post',
            destroy: 'delete'
        },
        writer: {
            type: 'json',
            allowSingle: false
        }
    }
});