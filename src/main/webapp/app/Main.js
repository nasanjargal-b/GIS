Ext.application({
    name: 'App',
    appFolder: '/app',
    controllers: ['MainCtrl'],
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [
                {
                    region: 'north',
                    xtype: 'mainMenu'
                },
                {
                    region: 'center',
                    xtype: 'component',
                    style: 'background:#ffffff; border:1px solid #99bce8;',
                    id: 'mainFrame',
                    autoEl: {
                        tag: 'iframe',
                        frameBorder: '0',
                        name: 'mainFrame'
                    }
                }
            ]
        });
    }
});