/**
 * Created by artem on 19.04.2017.
 */
class eswrew {

    char separator = ';'
    def countNew = 0;
    def countUpdate = 0;
    def file = request.getFile('file')
    def reader = file.inputStream.newReader()
    def csv = new CSVReader(reader, separator)

    def strategy = new HeaderColumnNameMappingStrategy<Client>()
    strategy.setType(Client.class)
    CsvToBean<Client> csvToBean = new CsvToBean<>()
    List<Client> clientList = csvToBean.parse(strategy, csv)

    for(client in clientList){
        def clientFind = Client.findByEmail(client.email);
        if (!clientFind) {
            geocodeService.getGeocode(client)
            client.save(flush: true)
            countNew++
        } else {
            if (!clientFind.name.equals(client.name) || !clientFind.street.equals(client.street) || !clientFind.zip.equals(client.zip)) {
                geocodeService.getGeocode(client)
                def data = [name:client.name, street:client.street, zip:client.zip, lat:client.lat, lng:client.lng]
                bindData(clientFind, data)

                if (clientFind.isDirty()) {
                    clientFind.save(flush: true)
                    countUpdate++
                }
            }
        }
    }
    render "Импорт " + countNew + " новых клиентов и обновленно " + countUpdate + " клиентов"
}
