export default class temperatureData{

    #index

    data = {
        temp: new Array(1000).fill(null)
    }

    static addData(gyroData){
        const x = this.data['x'];
        const index = this.#index;

        if(index<1000){
            x[index] = gyroData.x;
            this.#index++;
        }
        else{
            x.shift();
            y.shift();
            z.shift();

            x.push(gyroData.x);
            y.push(gyroData.y);
            z.push(gyroData.z);
        }

    }
}
