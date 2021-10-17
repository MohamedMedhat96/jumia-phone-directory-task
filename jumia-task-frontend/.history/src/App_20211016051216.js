import { Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [pagination, setPagination] = useState({ page: 1, size: 10, total: 100 })
  const [rows, setRows] = useState([])
  const [searchObject, setSearchObject] = useState(null)

  const getData = (currentSearch, page, size) => {
    const url = 'http://localhost:8080/phoneNumber/search' + "?page=" + page + "&size=" + size;
    axios({ method: 'get', url: url, data: currentSearch }).then((response) => {
      const newPagination = { page, size: size, total: response.data.totalElements }
      setPagination(newPagination)
      setRows(response.data.phoneNumbers)
    })
  }
  useEffect(() => {
    getData(searchObject, pagination.page, pagination.size);

  }, [])

  const stateSearch = () => {
    return <div>
      <Search
        placeholder="Search"
        onChange={e => console.log(e.target.value)}>
      </Search> </div>
  }
  const columns = [
    { title: "Phone Number", dataIndex: "phoneNumber", key: "phoneNumber" },
    {
      title: "Country Code", dataIndex: "country.countryCode", key: "countryCode", render: (text, record) => {
        return <div>{record.country?.countryCode}</div>;
      }
    },
    {
      title: "Country Name", dataIndex: "country.countryName", key: "countryName", filterDropdown: stateSearch, render: (text, record) => {
        return <div>{record.country?.countryName}</div>;
      }
    },
    {
      title: "State", dataIndex: "state", key: "state", filters: [{ text: "True", value: "true" }, {
        text: "False", value: "false",
      }], render: (text, record) => {
        return <div>{record.state.toString()}</div>;
      }
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
      pagination={pagination}
      onChange={(paginationChanged, filters) => {
        pagination.page = paginationChanged.current
        setPagination(pagination)
        if (filters.countryName) {
          filters.state = null;
          setSearchObject({ searchField: 'COUNTRY', searchValue: filters.countryName })
        } else {
          filters.countryName = null;
          setSearchObject({ searchField: 'STATE', searchValue: filters.state })
        }
        getData(searchObject, pagination.page, pagination.size);
      }}>

    </Table >
  );
}

export default App;
