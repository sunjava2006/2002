import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind(('127.0.0.1', 5000))

server.listen(5)

s, addr = server.accept()

# while True:
data = s.recv(10240)
msg = data.decode('utf-8')
print(msg)
    # if msg.endswith("\n\n"):
    #     break
response = """HTTP/1.1 200 OK\nContent-Type:application/json\n\n\n{"name":"wang"}"""
s.send(response.encode('utf-8'))

print("---------------------------")


s.close()


