from flask import Flask, jsonify,request


app = Flask("dfdfaf")

@app.route("/w")
def w():
    return jsonify({"温度":"20", "天气":"晴"}), 200, {"Access-Control-Allow-Origin":"*"}



@app.route("/wold")
def wold():
    print("====================================")
    method = request.values.get('jsonp')
    if not method:
        method = 'jsonp'
    data = 'function '+method+'(){return {"天气":"雪"}}'
    length = len(data.encode('utf-8'))
    return data, 200, {"Content-Type": "application/octet-stream", "Content-Length": length}

if __name__ == "__main__":
    app.run(debug=True)

