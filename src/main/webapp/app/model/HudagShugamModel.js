Ext.define('App.model.HudagShugamModel',{
    extend:'Ext.data.Model',
    fields:[
        {name: 'hudagShugamId', type: 'int', useNull: false}
        ,{name: 'zug', type: 'auto', useNull: false}
        ,{name: 'torol', type: 'auto', useNull: false}
        ,{name: 'diameter', type: 'float', useNull: false}
        ,{name: 'too', type: 'int', useNull: false}
        ,{name: 'hSmaterialId', type: 'int', useNull: false}
        ,{name: 'haaltId', type: 'int', useNull: false}
        ,{name: 'haaltDiameter', type: 'float', useNull: false}
        ,{name: 'haaltToo', type: 'int', useNull: false}
    ]
})