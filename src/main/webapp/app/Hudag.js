Ext.application({
    name: 'App',
    appFolder: '/app',
    controllers: ['HudagCtrl'],
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'HudagGrid'
            }
        });
    }
});