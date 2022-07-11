package main

import (
    "context"
    "go.mongodb.org/mongo-driver/bson"     
    "go.mongodb.org/mongo-driver/mongo" 
)

func updateRecord(collection *mongo.Collection, ctx context.Context, data map[string]interface{})(map[string]interface{}, error){            

    filter := bson.M{"product_id": data["product_id"]}
    fields := bson.M{"$set": data}

    d, err := collection.UpdateOne(ctx, filter, fields)

    if err != nil { 
        return nil, err                    
    }

    res := map[string]interface{}{
                "data" : d,   
                "code": 200,
                "message": "successful",
           } 

    return res, nil
}