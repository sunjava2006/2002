// miniprogram/pages/newslist/newslist.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        typeList:['头条','社会','国内','国际','娱乐','体育','军事','科技','财经','时尚'],
        currentID:0

    },

    select(evt){
        console.log(evt);
        // 取出事件对象evt中target属性对应的view的ID值。
        var currID = evt.target.id;
        // 将这个ID值，赋给currentID.
        this.setData({currentID:currID});

    },
    swiperChange:function(evt){
        console.log(evt);
        // 取出Swiper的当前id.
        var currID = evt.detail.current;
        this.setData({currentID: currID});
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