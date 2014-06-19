Ext.define('App.store.TagStore', {
    extend: 'Ext.data.Store',
    fields: [
        {name: 'tagId', type: 'int'}
        ,{name: 'name', type: 'string'}

    ],
    autoLoad:true,
    proxy: {
        url: '/tag/tags.json',
        type: 'ajax',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});