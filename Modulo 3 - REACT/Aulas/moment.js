console.log(moment().format('DD MM YYYY'));
console.log(moment().format('DD MM YYYY HH:mm:ss'));
console.log(moment().subtract(10, 'days').format('DD MM YYYY HH:mm:ss'));
console.log(moment().add(365, 'days').format('DD MM YYYY HH:mm:ss'));

let now = moment();
console.log(now.tz('America/New_York').format('LLL'));
