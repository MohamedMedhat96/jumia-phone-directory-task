import { Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [pagination, setPagination] = useState({ page: 1, size: 10, total: 100 })
  const [rows, setRows] = useState([])

  useEffect(() => {
    const url = 'http://localhost:8080/phoneNumber/search' + "?page=" + pagination.page + "&size=" + pagination.size;
    axios({ method: 'get', url: url }).then((response) => {
      const newPagination = { page: pagination.page, size: pagination.size, total: response.data.totalElements }
      setPagination(newPagination)
      setRows(response.data.phoneNumbers)
      console.log(response.data.phoneNumbers)
    })
  }, [])

  const stateSearch = () => {
    return <div>
      <Search
        placeholder="Search"
        onChange={e => console.log(e.target.value)}
        onPressEnter={console.log("search")}>
      </Search> </div>
  }
  const columns = [
    // { title: "Phone Number", dataIndex: "phoneNumber", key: "phoneNumber" },
    {
      title: "State", dataIndex: "state", key: "state", filters: [{ text: "True", value: "true" }, {
        text: "False", value: "false", render: (text, record) => {
          return <div>{record.state}</div>
        }
      }]
    }
    //{ title: "Country Name", dataIndex: "countryName", key: "countryName", filterDropdown: stateSearch },
    //{ title: "Country Code", dataIndex: "countryCode", key: "countryCode" }
  ]
  return (
    <Table
      columns={columns}
      dataSource={rows}
      rowKey={record => record.phoneNumber}
      style={{ width: '75%', height: '100%', display: 'block', marginLeft: 'auto', marginRight: 'auto' }}
      pagination={pagination}>
    </Table >
  );
}

export default App;
