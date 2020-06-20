// pages/wifi/wifi.js
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },
    getWifi(lon, lat, r) {
        // 请求后台服务器
        wx.request({
            url: 'http://apis.juhe.cn/wifi/local?lon=' + lon + '&lat=' + lat + '&gtype=1&r=' + r + '&dtype=json&key=743a48cdd71f773a6d7dee71c18d2964',
            success: (data) => {
                // 取出返回的WiFi数组．
                var locationList = data.data.result.data;
                console.log(locationList);
                // 获取已经存在的markers
                var markers = this.data.markers;
                // 遍历返回的数据
                for (var i in locationList) {
                    var location = locationList[i];
                    // 将返回的每一个wifi点，生成一个marker对象。
                    var marker = {
                        "id": i + 1,
                        longitude: location.baidu_lon,
                        latitude: location.baidu_lat,
                        iconPath: "/imgs/wifi.png",
                        width: 50,
                        height: 50
                    };
                    // 向markers数组中，添加wifi marker.
                    markers.push(marker);
                }
                // setData才会刷新页面显示.
                this.setData({markers});
                
               
            }
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        // 获取当前位置
        wx.getLocation({
            // 成功获取当前位置的回调函数
            success: (res) => {
                console.log(res);
                var longitude = res.longitude;
                var latitude = res.latitude;
                this.getWifi(longitude, latitude, 5000);
                var markers = [{
                    id: 0,
                    longitude,
                    latitude,
                    iconPath: "/imgs/location.png",
                    width: 50,
                    height: 50
                }];
               
                this.setData({
                    "longitude": longitude,
                    latitude,
                    markers
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