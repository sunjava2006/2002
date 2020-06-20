// input-modal/input-modal.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        title:{
            type:String,
            value:"Title"
        },
        input_type:{
            type:String,
            value:"text"
        },
        input_name:{
            type:String,
            value:"key"
        },
        placeholder:{
            type:String,
            value:"在此输入内容"
        },
        btn_canel_name:{
            type:String,
            value:"取消"
        },
        btn_confirm_name:{
            type:String,
            value:"确定"
        },
        show:{
            type:Boolean,
            value:true
        }

    },

    /**
     * 组件的初始数据
     */
    data: {
        focus:false
    },

    /**
     * 组件的方法列表
     */
    methods: {
        onfocus(evt){
            this.setData({focus:true});
        },
        onblur(evt){
            this.setData({focus:false});
        },
        oncancel(evt){
            this.setData({show:false});
            console.log(evt);
            this.triggerEvent("modalcancel", evt);
        },
        onsubmit(evt){
            console.log(evt);
            this.setData({ show: false });
            this.triggerEvent("modalconfirm", evt.detail);
        }
    }
})
