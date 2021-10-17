import { notification, Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [pagination, setPagination] = useState({ page: 0, size: 10, total: 100 })
  const [rows, setRows] = useState([])
  const [searchObject, setSearchObject] = useState(null)
  const [stateFilter, setStateFilter] = useState(null)
  const [countryFilter, setCountryFilter] = useState(null)

  const getData = (currentSearch, page, size) => {
    const url = 'http://192.168.99.100:8080/phoneNumber/search' + "?page=" + page + "&size=" + size;
    axios.post(url, currentSearch, { headers: { 'Content-Type': "application/json" } }).then((response) => {
      const newPagination = { page, size, total: response.data.totalElements }
      setPagination(newPagination)
      setRows(response.data.phoneNumbers)
    }).catch((error) => {
      if (error.response) {
        notification.error({ title: 'Error', description: error.response.data })
      } else {
        if (error.request) {
          notification.error({ title: 'Error', description: "Can't reach the backend server, please adjust the url" })
        }
      }
    })
  }
  useEffect(() => {
    getData(searchObject, pagination.page, pagination.size);

  }, [searchObject])

  const stateSearch = () => {
    return <div >
      <
        Search
        placeholder="Search"
        onChange={
          (e) => {
            setStateFilter(null)
            if (e.target.value != "")
              setCountryFilter(e.target.value)
            else
              setCountryFilter(null)
          }
        }
        onPressEnter={
          () => {
            if (countryFilter)
              setSearchObject({ searchField: 'COUNTRY', searchValue: countryFilter })
            else
              setSearchObject(null)
          }
        } >
      </Search> </div >
  }
  const columns = [
    { title: "Phone Number", dataIndex: "phoneNumber", key: "phoneNumber" },
    {
      title: "Country Code",
      dataIndex: "country.countryCode",
      key: "countryCode",
      render: (text, record) => {
        return <div > {record.country?.countryCode} </div>;
      }
    },
    {
      title: "Country Name",
      dataIndex: "country.countryName",
      key: "countryName",
      filterDropdown: stateSearch,
      render: (text, record) => {
        return <div> {record.country?.countryName} </div>;
      }
    },
    {
      title: "State",
      dataIndex: "state",
      key: "state",
      filters: [{ text: "True", value: "true" }, {
        text: "False",
        value: "false",
      }],
      filteredValue: stateFilter,
      render: (text, record) => {
        return <div> {record.state.toString()} </div>;
      }
    }
  ]
  return (<
    Table columns={columns}
    dataSource={rows}
    rowKey={record => record.phoneNumber}
    style={
      { width: '75%', height: '100%', display: 'block', marginLeft: 'auto', marginRight: 'auto' }
    }
    pagination={pagination}
    onChange={
      (paginationChanged, filters) => {
        console.log(paginationChanged)
        if (filters.state) {
          setCountryFilter(null)
          setStateFilter(filters.state)
          if (filters.state?.length == 1)
            setSearchObject({ searchField: 'STATE', searchValue: filters.state[0] })
          else
            setSearchObject(null)
        }
        getData(searchObject, paginationChanged.current - 1, paginationChanged.size);
      }
    } >

  </Table>
  );
}

export default App;