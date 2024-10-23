export default class gyroscopeData{

    static channels = 3
    static data = {
        x: Array.from({length: 1000}, (e, i)=> {return {x:i,y:1}}),
        y: Array.from({length: 1000}, (e, i)=> {return {x:i,y:1}}),
        z: Array.from({length: 1000}, (e, i)=> {return {x:i,y:1}})
    }
    static index = 0;
    
    static addData(gyroData){
        const x = this.data['x'];
        const y = this.data['y'];
        const z = this.data['z'];
        const index = this.index;

        if(index<100){
            x[index][1] = gyroData.x;
            y[index][1] = gyroData.y;
            z[index][1] = gyroData.z;
            this.index++;
        }
        else{
            x.shift();
            y.shift();
            z.shift();

            x.push([this.index,gyroData.x]);
            y.push([this.index,gyroData.y]);
            z.push([this.index,gyroData.z]);
            this.index++;
        }

    }
}