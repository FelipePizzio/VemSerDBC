import axios from 'axios'

export default class FilesApiConnector {
    uploadFile = (file) => axios.post('http://localhost:8080/api/arquivo/uploadFile', file)
    downloadFile = () => axios.get('http://localhost:8080/api/arquivo/downloadFile/{fileName:.+}')
}