import socket

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 连接远程计算机（对方的地址）
client.connect(('127.0.0.1', 9999))

msg = input("输入一个消息：")+"\n"
data = msg.encode("utf-8")
client.send(data)

data = client.recv(1024)
msg = data.decode("utf-8")
print(msg)


client.close()
