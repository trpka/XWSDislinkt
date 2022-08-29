
interface JobOfferInterface
{
    id?: number;
    position: string;
    description: string;
    daily_activities: string[];
    qualifications: string[];
}

export class JobOffer implements JobOfferInterface
{
    id?: number;
    position: string;
    description: string;
    daily_activities: string[];
    qualifications: string[];

    constructor(obj: JobOfferInterface)
    {
        this.id = obj.id;
        this.position = obj.position;
        this.description = obj.description;
        this.daily_activities = obj.daily_activities;
        this.qualifications = obj.qualifications;
    }
    
    
}