// pages/dww/dww.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    classes:["c","java"]
  },
  addProject:function(e){ // e是一个事件对象。这个对象中表示我们发送表单事件。从这个对象中可以获取表单的信息。
    console.log(e);       // 输出这个对象，看一下。
    var val = e.detail.value.newProject;  // 这个对象的detail.value中包含我们input对象的数据。这个input的name是newProject。我们取出这个数据值。
    var classes = this.data.classes; // 获取原来的classes数组对象。
    classes.push(val)                // 为这个数组对象，添加我们输入的新的数据。
    this.setData({classes:classes}); // 更新data 对象。


  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showToast({
      title: '输入为空'

    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})