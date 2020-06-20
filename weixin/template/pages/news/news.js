// pages/news/news.js
Page({
    show(event) {
        console.log(event)
        var url = event.currentTarget.id;
        console.log(url);
        url = encodeURIComponent(url);
        console.log("encode:"+url);
        url = '/pages/show/show?url=' + url
        console.warn(url);
       
        // 打开show页面，并传递url做为参数
        wx.navigateTo({
            url: url
        })
    },
    /**
     * 页面的初始数据
     */
    data: {
        types:["top", "shehui", "guonei", "guoji", "yule"],
        newsList:[],
        current:0
    },
    changeType(event){
        console.log(event);
        this.setData({
            current:event.detail.currentItemId
        });
        this.listNews(this.data.types[this.data.current]);
    },
    listNews(type){
        wx.request({
            url: 'http://v.juhe.cn/toutiao/index?type='+type+'&key=082153265794dc7a4bdb119e272319ee',
            success: (data) => {
                console.log(data);
                var newsList = data.data.result.data;
                this.setData({
                    "newsList": newsList
                });
            }
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        this.listNews(this.data.types[this.data.current]);
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