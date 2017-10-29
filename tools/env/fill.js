function insertData(dbName, colName, num) {

    var col = db.getSiblingDB(dbName).getCollection(colName);
    var bulk = col.initializeUnorderedBulkOp();

    for (i = 0; i < num; i++) {
        bulk.insert({userId:i.toString(), targetAccount:"target", amount:100.0, dueDate: ISODate("2017-07-16T12:00:00.000Z") });
    }

    bulk.execute();

    print(col.count());

}
print(database);
insertData(database, collection, rows);
