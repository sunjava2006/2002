Component({
    options: {
        addGlobalClass: true,
        multipleSlots: true
    },
    properties:{
        label:{
            type:String,
            value:"label"
        },
        type:{
            type:String,
            value:"text"
        },
        placeholder:{
            type:String,
            value:"输入文字内容"
        }
    }
})