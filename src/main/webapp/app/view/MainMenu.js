Ext.define('App.view.MainMenu', {
    extend: 'Ext.toolbar.Toolbar',
    alias: 'widget.mainMenu',
    border: false,
    defaults: {
        hrefTarget: 'mainFrame'
    },
    items: [
        {
            text: 'Аймаг',
            href: '/Aimag.html'
        },
        {
            text: 'Бохирын худаг',
            href: '/hudag.jsp?torol=BO'
        },
        {
            text: 'Цэвэр,Дулааны худаг',
            href: '/hudag.jsp?torol=TD'
        },
        {
            text: 'Цэвэрийн Шугам',
            href: '/ShugamHooloi.html?torol=TS'
        },
        {
            text: 'Бохирын Шугам',
            href: '/ShugamHooloi.html?torol=BO'
        },
        {
            text: 'Дулааны Шугам',
            href: '/ShugamHooloi.html?torol=DU'
        },
        '->',
        Ext.create('Ext.form.ComboBox', {
            queryMode: 'local',
            displayField: 'aimagName',
            valueField: 'aimagId',
            fieldLabel: 'Сонгосон аймаг',
            labelWidth: 95,
            store: Ext.create('App.store.AimagStore', {
                autoLoad: true
            }),
            listeners: {
                afterrender: function (cmb) {
                    Ext.Ajax.request({
                        url: '/aimag/aimagCheck.json',
                        method: 'post',
                        success: function (response) {
                            var rdata = Ext.decode(response.responseText);
                            cmb.setValue(parseInt(rdata.data.aimagId));
                        }
                    });
                },
                change: function (cmb, newValue) {
                    Ext.Ajax.request({
                        url: '/aimag/aimagSelect.json',
                        method: 'post',
                        params: {
                            aimagId: newValue
                        },
                        success: function (response) {
                            document.getElementById('mainFrame').contentWindow.location.reload();
                        }
                    });
                }
            }
        })
    ]
});