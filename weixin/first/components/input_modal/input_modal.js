// components/input_modal/imput_modal.js
Component({
   options:{
     addGlobalClass:true,
     multipleSlots:true
   },

  /**
   * 组件的属性列表
   */
  properties: {
    isShowModal:{
      type:Boolean,
      value: false
    },
    isShowTitle:{
      type:Boolean,
      value: true
    },
    modalTitle:{
      type: String,
      value:"标题"
    },
    placeholder:{
      type: String,
      value: "请输入文字"
    },
    showDesc:{
      type: String,
      value:""
    },
    inputType:{
      type: String,
      value: "text"
    },
    inputName:{
      type: String,
      value:"val"
    },
    isShowInput:{
      type:Boolean,
      value: true
    },
    inputVal:{
      type:[String, Number],
      value: ''
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    isFous:false
  },

  /**
   * 组件的方法列表
   */
  methods: {
    bindFous(){
      this.setData({isfous:true})
    },
    bindBlur(){
      this.setData({isfous:false})
    },
    _bindInput(e){
      console.log('_bindInput')
      console.log(e)
      this.triggerEvent('customBindInput', e.detail.value)
    },
    _cancel(){
      console.log('btn cancel tap..........')
      this.triggerEvent('cancel')
    },
    _confirm(e){
      console.log('btn confirm tap..........')
      this.triggerEvent('confirm',e.detail)
    }
  }
})
