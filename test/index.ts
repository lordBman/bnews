import axios, { AxiosError } from "axios";

const context = axios.create({ 
    baseURL: "https://api.newsdatahub.com/v1",
    headers: {
        'X-Api-Key': "z2Ir6L1soknPLlT-G26UsnrI0Yypn3_ICnxLk4qHWs0",
        'User-Agent': 'test/1.0'
    },
    withCredentials: true,
 });

 //https://newsdata.io/api/1/latest?apikey=pub_66705f2098a380da6cdb6fd90e81062f3b45f&country=ng
 //https://ok.surf/#endpoints

 /*context.get("/topics/top").then((response)=>{

 }).catch((error)=>{

 });*/

 context.get("/news?language=en&topic=sports").then((response)=>{
    console.log(JSON.stringify(response.data));
 }).catch((error)=>{
    const init = (error as AxiosError);

    console.error(JSON.stringify(init.response?.data));
 })

console.log("Hello via Bun!");