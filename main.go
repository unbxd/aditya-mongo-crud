package main

import (
    "context"
    "net/http"
    "encoding/json" 
    _"log" 
    "fmt" 
    "go.mongodb.org/mongo-driver/mongo" 
    "go.mongodb.org/mongo-driver/mongo/options"         
)

const connectionString="mongodb://localhost:27017/"
const dbName="shop_db"
const colName="products"

var collection *mongo.Collection

func init(){
	clientOption := options.Client().ApplyURI(connectionString)
	fmt.Println("err")
	client,err := mongo.Connect(context.TODO(),clientOption)
	if err!=nil{
		fmt.Println(err)
	}

	client.Database(dbName).Collection(colName)
}

func main() {
     http.HandleFunc("/products", requestHandler)
     http.ListenAndServe(":8080", nil)
}

func requestHandler(w http.ResponseWriter, req *http.Request) {

    w.Header().Set("Content-Type", "application/json")

    response := map[string]interface{}{}

    ctx := context.Background()

    client, err := mongo.Connect(ctx, options.Client().ApplyURI(connectionString))

    if err != nil { 
        fmt.Println(err.Error())
    } 

    collection := client.Database(dbName).Collection("products")  

    data := map[string]interface{}{} 

    err = json.NewDecoder(req.Body).Decode(&data)

    if err != nil { 
        fmt.Println(err.Error())
    }

    switch req.Method {
        case "POST":
            response, err = createRecord(collection, ctx, data)
        case "GET":
            response, err = getRecords(collection, ctx)
        case "PUT":
            response, err = updateRecord(collection, ctx, data)
        case "DELETE":
            response, err = deleteRecord(collection, ctx, data)
    }

    if err != nil { 
        response = map[string]interface{}{"error": err.Error(),}  
    } 

    enc := json.NewEncoder(w)
    enc.SetIndent("", "  ")

    if err := enc.Encode(response); err != nil {
        fmt.Println(err.Error())
    }   
}