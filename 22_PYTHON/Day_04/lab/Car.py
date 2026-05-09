class Car:
    def __init__(self, name, fuelRate, velocity):
        self.name = name
        
        if 0 <= fuelRate <= 100:
            self.fuelRate = fuelRate
        else:
            raise ValueError("fuelRate must be between 0 and 100")
            
        if 0 <= velocity <= 200:
            self.velocity = velocity
        else:
            raise ValueError("velocity must be between 0 and 200")

    def run(self, distance, velocity):
        if 0 <= velocity <= 200:
            self.velocity = velocity
        else:
            print("Velocity must be between 0 and 200. Setting to max allowed.")
            self.velocity = 200 if velocity > 200 else 0
            
        if distance <= self.fuelRate:
            self.fuelRate -= distance
            self.stop(0)
        else:
            remain_distance = distance - self.fuelRate
            self.fuelRate = 0
            self.stop(remain_distance)

    def stop(self, remain_distance):
        self.velocity = 0
        if remain_distance == 0:
            print("Arrived at the destination!")
        else:
            print(f"Stopped out of fuel with {remain_distance}km remaining.")

    def setFuelRate(self, rate):
        if 0 <= rate <= 100:
            self.fuelRate = rate
        else:
            print("fuelRate must be between 0 and 100")