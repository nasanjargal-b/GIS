Ext.define('App.store.AimagStore', {
    extend: 'Ext.data.Store',
    fields: [
        {name: 'aimagId', type: 'int', useNull: false}
        ,{name: 'aimagName', type: 'string', useNull: false}
    ],
    autoLoad: false,
    proxy: {
        url: '/aimag/aimags.json',
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