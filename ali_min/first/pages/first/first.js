Page({
  data: {
    "sayHello": "晚上好"
  },
  onLoad() {

    var now = new Date();
    var hour = now.getHours();
    var msg = "晚上好";
    if (hour < 23) {
      msg = "白天好"
    }
    this.setData({
      "sayHello": msg
    });

  },
});
