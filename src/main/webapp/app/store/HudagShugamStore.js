Ext.define('App.store.HudagShugamStore', {
    extend: 'Ext.data.Store',
    fields: [
        {name: 'hudagShugamId', type: 'int', useNull: false}
        ,{name: 'zug', type: 'auto', useNull: false}
        ,{name: 'torol', type: 'auto', useNull: false}
        ,{name: 'diameter', type: 'float', useNull: false}
        ,{name: 'too', type: 'int', useNull: false}
        ,{name: 'hSmaterialId', type: 'int', useNull: false}
        ,{name: 'hSmaterialName', type: 'string', useNull: false}
        ,{name: 'haaltId', type: 'int', useNull: false}
        ,{name: 'haaltName', type: 'string', useNull: false}
        ,{name: 'haaltDiameter', type: 'float', useNull: false}
        ,{name: 'haaltToo', type: 'int', useNull: false}
    ],
    autoLoad: true,
    proxy: {
        url: '/hudagshugam/find.json',
        type: 'ajax',
        actionMethods: {
            read: 'get',
            create: 'post',
            update: 'post',
            destroy: 'delete'
        },
        reader: {
            type: 'json',
            root: 'data'

        },
        writer: {
            type: 'json',
            allowSingle: false
        }
    }
});