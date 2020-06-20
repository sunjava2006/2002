// pages/form/form.js
Page({
    peopleChange(evt){
        console.log(evt);
        this.setData({
            currentPeople:evt.detail.value
        });
    },
    timeChange(evt){
        this.setData({
            time: evt.detail.value
        });
    },
    addressChange(evt){
        this.setData({
            address:evt.detail.value
        });

    },
    birthDateChange(evt){
        this.setData({
            birthDate:evt.detail.value
        });
    },

    onsubmit(evt){
        console.log(evt);
    },
    /**
     * 页面的初始数据
     */
    data: {
        address:["江苏省","南京市","浦口区"],
        birthDate:"2009-6-4",
        time:"12:30",
        peopleList:["王瑞", "王英", "陈阳"],
        currentPeople:0
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

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