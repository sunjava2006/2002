// pages/tel/tel.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        list:[{name:"中国电信", num:10000},
              {name:"中国移动", num:10086},
              {name:"胡世民", num: 18851190057}]
       

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

    },

    call: function(event){

        console.log(event);
        // 取出View对象的ID的值。这个值，就是电话号码。
        var telNum = event.target.id;

        // 调用微信的打电话方法。
        wx.makePhoneCall({
            phoneNumber: telNum
        })
    }
    
})