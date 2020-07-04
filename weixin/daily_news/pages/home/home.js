// pages/home/home.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        typeList:[
            {"name":"头条", value:"top"},
            {"name":"社会", value:"shehui"}, 
            {"name":"国内", value:"guonei"},
            {"name":"国际", value:"gouji"},
            {"name":"娱乐", value:"gougi"},
            {"name":"体育", value:"tiyu"},
            {"name":"军事", value:"junshi"},
            {"name":"科技", value:"kejin"},
            {"name":"财经", value:"caijing"},
            {"name":"时尚", value:"shishang"}
            ],
        current:0
    },
    selectType(event){
        console.log(event);
        var id = event.target.id;
        this.setData({
            current:id
        });
    },
    slide(event){
        console.log(event);
        var id = event.detail.current;
        this.setData({
            current:id
        });
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