// pages/map/map.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        circles: [{
            longitude: 118.62733378372195,
            latitude: 32.05977100498963,
            radius: 20,
            color: "#ff0000",
            fillColor: "#00000000"

        }]


    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        // var that = this;
        wx.getLocation({
            type: "gcj02", // 使用国测局数据，会准确很多。

            success: (res) => {
                console.log(res);
                var longitude = res.longitude;
                var latitude = res.latitude;
                this.setData({
                    "longitude": longitude,
                    "latitude": latitude,
                    "markers": [{
                        "id": 0,
                        "longitude": longitude,
                        "latitude": latitude,
                        "title": "My",
                        "iconPath": "/imgs/location.png",
                        "width": "30px",
                        "height": "30px",
                        "label":{content:"xxx",bgColor:"#ff0000"}

                    }],
                    line: [{
                        points: [{
                            longitude: 118.62733378372195,
                            latitude: 32.05977100498963
                        }, {
                            longitude: longitude,
                            latitude: latitude
                        }],
                        color: "#0000ff"
                    }]
                });
            }
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