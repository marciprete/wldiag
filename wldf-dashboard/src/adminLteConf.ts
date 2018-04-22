export var adminLteConf = {
  skin: 'blue',
  sidebarLeftMenu: [
    {label: 'Dashboard', route: '/', iconClasses: 'fa fa-dashboard'},
    {label: 'Diagnostic images', route: '/di/list', iconClasses: 'fa fa-server'},
    {label: 'Transactions', iconClasses: 'fa fa-exchange', children: [
        {label: 'JTA Transactions',  route: '/transactions', iconClasses: "fa fa-exchange"},
        {label: 'Threads',  route: '/transactions/threads', iconClasses: "fa fa-hourglass-half"},
      ]},
    {label: 'JDBC', route: '/jdbc', iconClasses: 'fa fa-database'},
    {label: 'System',  iconClasses: 'fa fa-cog', children: [
        {label: 'Customers', route: "/customers", iconClasses: 'fa fa-users'}
      ]},
  ]
};
