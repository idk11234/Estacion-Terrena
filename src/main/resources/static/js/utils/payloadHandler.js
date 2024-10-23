import gyroscopeData from "../dataTypes/gyroscopeData.js";

export default class payloadHandler{

    static users = [];
    static packetNo = 0;
    static inUse(payloadUser){

        if(this.users.length === 0){
            this.users.push(payloadUser);
            window.stompClient.subscribe('/app/payload',function(message){
                const body = JSON.parse(message.body);

                body.data = JSON.parse(body.data);
                const data = {
                    packet : payloadHandler.packetNo,
                    payload:body.data
                }
                
                payloadHandler.users.forEach(user=>{
                    user.update(data);
                })
                payloadHandler.packetNo++;
            
            });
        }
        else{
            this.users.push(payloadUser);
        }
    }

    static unUse(node){
        this.users.forEach((user,i)=>{
            if(node == user){
                this.users.splice(i,1);
                console.log(user,node);
            }
        })        
    } 
}


function handlePayload(message){


}