export class ResourcePool {

  id: number;
  poolname: string;
  currentCapacity: number;
  availableResources: number;
  reservedResources: number;
  deadResources: number;

  get poolLoad() : number {
    if(this.reservedResources===0) {
      return 0;
    }
    return (1-(this.availableResources+this.deadResources)/this.reservedResources)*100;
  }
}
