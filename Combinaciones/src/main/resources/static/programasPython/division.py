from flask import Flask
app = Flask(__name__)

@app.route("/div/<int:a>/<int:b>",methods=['GET'])
def div(a,b):
    return str(a/b)

if __name__ == "__main__":
    app.run()
