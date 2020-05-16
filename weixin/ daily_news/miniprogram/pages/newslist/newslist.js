// miniprogram/pages/newslist/newslist.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        typeList:[{name:'头条', type:"top"},
                  {name:'社会', type:"shehui"},
                  {name:'国内', type:"guonei"},
                  {name:'国际', type:"guoji"},
                  {name:'娱乐', type:"yule"},
                  {name:'体育', type:"tiyu"},
                  {name:'军事', type:"junshi"},
                  {name:'科技', type:"keji"},
                  {name:'财经', type:"caijing"},
                  {name:'时尚', type:"shishang"}],
        currentID:0

    },

    select(evt){
        console.log(evt);
        // 取出事件对象evt中target属性对应的view的ID值。
        var currID = evt.target.id;
        // 将这个ID值，赋给currentID.
        this.setData({currentID:currID});

        this.loadNewsList();

    },
    swiperChange:function(evt){
        console.log(evt);
        // 取出Swiper的当前id.
        var currID = evt.detail.current;
        this.setData({currentID: currID});
        this.loadNewsList();
    },

    loadNewsList(){
        // 向聚合数据，发送请求，获取默认类型的数据（新闻列表）
        var appKey = "082153265794dc7a4bdb119e272319ee";
        var currType = this.data.typeList[this.data.currentID].type;
        // wx.request方法，用以向服务器发送请求，并获取返回的数据。
        wx.request({
            url: 'http://v.juhe.cn/toutiao/index',
            method: 'GET',
            data: {
                type: currType,
                key: appKey
            },
            header: {
                'content-type': 'application/json' // 默认值
            },
            success: (data) => {
                console.log(data);
                var newsList = data.data.result.data;
                this.setData({
                    "newsList": newsList
                });
            }
        })
    },

    showDetail(evt){
        console.log(evt);
        var url = evt.currentTarget.id;
        console.log('id 中的 URL:')
        console.log(url);

        url = url.replace("?", "&");

        console.log("after replace----------------------------")
        console.log(url)


        // 打开新的页面
        wx.navigateTo({
            url: '/pages/showNews/showNews?url='+url 
            //'https://v.juhe.cn/toutiao/s&&id=https%3A%2F%2Fmini.eastday.com%2Fmobile%2F200516205420423.html'


        })
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log(1)
        this.loadNewsList();
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
        console.log(2)
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