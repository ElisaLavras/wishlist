print('Create DB #################################################################');
db = db.getSiblingDB('wish_list_db');

db.createCollection('wish_product_collection');
