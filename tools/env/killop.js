function killLongOp(sec) {
    db.currentOp()['inprog'].forEach(function (query) {
        if (query.op !== 'query') {
            return;
        }
        if (query.secs_running < sec) {
            return;
        }

        print(['Killing query:', query.opid,
            'which was running:', query.secs_running, 'sec.'].join(' '));
        db.killOp(query.opid);
    })
}

killLongOp(1);

