//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },
  // 当加载这个页面时，调用的方法
  onLoad: function () {
    // 请求微信返回当前位置  
    wx.getLocation({
        type:"gcj02",  // gps数据
        // 成功获取位置数据时，调用success
        success:function(res){ 
            console.log(res);
            var longitude = res.longitude; // 取出返回的经度
            var latitude = res.latitude;   // 取出纬度

            // 调用微信地图 
            wx.openLocation({
                longitude: longitude,
                latitude: latitude,
                scale:5,
                name:"我在这",
                address:"XXX街XXX号"
                
            })
        },
        // 在获取地理位置失败的情况下，被调用。
        fail:function(){
            // 提示框
            wx.showToast({
                title: '获取位置失败',
                icon: "none",
                image: "/imgs/failure_toast.png",
                duration: 5000
            })
        }

    })
  }
})
