$.extend($.fn.etree.defaults, {
	editMsg: {
		norecord: {
			title: '警告',
			msg: '请先选择节点后再进行修改操作。'
		}
	},
	destroyMsg: {
		norecord: {
			title: '警告',
			msg: '请先选择节点后再进行删除操作。'
		},
		confirm: {
			title: '确认',
			msg: '是否真的删除选定的节点？'
		}
	}

});