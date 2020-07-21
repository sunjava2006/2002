import socket

# 创建一个socket对象。协议族是internet IP。 类型是TCP
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 定义一个地址：元组类型，存储 ip 和 端口。
address = ("127.0.0.1", 9999)
# 将这个地址与socket绑定。就是向操作系统申请这个地址。
server.bind(address)

# 服务端进行监听
print("服务端监听---------------------")
server.listen(5)

while True:
    # 接收用户的连接，当没有连接时阻塞。返回对方连接的socket和对方的地址（ip, port）
    s, addr = server.accept()
    print("服务端监听到有用户请求---------------------")
    d = b''
    while True:
        # 接收用户发送来的数据
        data = s.recv(4)
        d += data
        if data.endswith(b'\n'):
            break

    response_msg = "我收到的消息是:"+d.decode('utf-8')
    data = response_msg.encode("utf-8")
    s.send(data)
    s.close()
# 关闭socket
server.close()

print("服务端结束")


