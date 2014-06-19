Ext.define('App.store.HaaltMaterialStore', {
    extend: 'Ext.data.Store',
    fields: [
        {name: 'materialId', type: 'int', useNull: false}
        ,{name: 'name', type: 'string', useNull: false}
        ,{name: 'zoriulalt', type: 'auto', useNull: false}
    ],
    autoLoad: true,
    proxy: {
        url: '/material/materials.json?zoriulalt=HAALT',
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