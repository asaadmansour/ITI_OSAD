// mongorestore -d inventory
db.employee.aggregate([
  {
    $lookup: {
      from: "department",
      localField: "department_id",
      foreignField: "department_id",  
      as: "departments",
    },
  },
],{full_name:1,"departments.department_description":1});
// Display
// employees with position “VP Country Manager” (only display employee full name and
// salary)
db.employee.find({position_title:"VP Country Manager"},{full_name:1,salary:1,_id:0})

//Display customers full names and their regions.
db.customer.aggregate([
  {
    $lookup: {
      from: "region",
      localField: "address.customer_region_id",
      foreignField: "region_id",
      as: "customers_regions"
    }
  },
  {
    $project: {
      _id: 0,
      full_name: 1,
      "customers_regions.sales_region": 1 
    }
  }
])
// customer got regionid in address we can connect to

db.product.find({brand_name: "Washington"},{})
// Group products by brand name, count number and display the result as follow:
db.product.aggregate([
  {
    $group: {                   
      _id: "$brand_name",        
      totalCount: { $sum: 1 }
    }
  }
])
// Group products by brand_name and product_name ,only select brand names
// ("Blue Label","King","Washington") then sort them by brand_name and
//  product_name ascending and display result as follow 
db.product.aggregate([
  {
    $match: {
      brand_name: { $in: ["Blue Label", "King", "Washington"] }
    }
  },
  {
    $group: {
      _id: {
        brand_name: "$brand_name",
        product_name: "$product_name"
      }
    }
  },
  {
    $sort: {
      "_id.brand_name": 1,
      "_id.product_name": 1
    }
  }
])