import mongoose from "mongoose";


const connectToDatabase = async () => {
  try {
    const DB_OPTIONS = {
      dbName: process.env.DBNAME,
      user: process.env.DBUSERNAME,
      pass: process.env.DBPASSWORD,
      authSource: process.env.AUTHSOURCE
    };
    
    
    await mongoose.connect(process.env.DATABASE_URL, DB_OPTIONS);
    console.log("connected successfully");
  } catch (error) {
    console.log(error);
  }
};

export default connectToDatabase;



